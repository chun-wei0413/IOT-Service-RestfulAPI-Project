package com.example.Fproject.database.entity;
import com.example.Fproject.database.dao.deviceRepository;
import com.example.Fproject.database.dao.userRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    @Autowired
    private deviceRepository deviceRepository;
    @Autowired
    private userRepository userRepository;

    @PostConstruct
    public void init() {
        deviceRepository.save(new device("001", "https://2112-49-216-45-231.ngrok-free.app", "56YR34","light","GPIO003","0"));
        deviceRepository.save(new device("002", "http://002", "97WER4","fan","GPIO456","1"));
        userRepository.save(new user( "fanjiang", "97WER4"));
    }
}

