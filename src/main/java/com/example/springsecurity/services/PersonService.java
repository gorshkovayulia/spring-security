package com.example.springsecurity.services;

import com.example.springsecurity.entities.Otp;
import com.example.springsecurity.entities.Person;
import com.example.springsecurity.repositories.OtpRepository;
import com.example.springsecurity.repositories.PersonRepository;
import com.example.springsecurity.utils.GenerateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private OtpRepository otpRepository;

    public void addPerson(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRepository.save(person);
    }

    public void auth(Person person) {
        Optional<Person> o = personRepository.findUserByUsername(person.getUsername());
        if(o.isPresent()) {
            Person p = o.get();
            if (passwordEncoder.matches(
                    person.getPassword(),
                    p.getPassword())) {
                renewOtp(p);
            } else {
                throw new BadCredentialsException
                        ("Bad credentials.");
            }
        } else {
            throw new BadCredentialsException
                    ("Bad credentials.");
        }
    }

    public boolean check(Otp otpToValidate) {
        Optional<Otp> personOtp = otpRepository.findOtpByUsername(otpToValidate.getUsername());
        if (personOtp.isPresent()) {
            Otp otp = personOtp.get();
            return otpToValidate.getCode().equals(otp.getCode());
        }
        return false;
    }

    private void renewOtp(Person person) {
        String code = GenerateCodeUtil.generateCode();
        Optional<Otp> personOtp = otpRepository.findOtpByUsername(person.getUsername());

        if (personOtp.isPresent()) {
            Otp otp = personOtp.get();
            otp.setCode(code);
        } else {
            Otp otp = new Otp();
            otp.setUsername(person.getUsername());
            otp.setCode(code);
            otpRepository.save(otp);
        }
    }
}
