package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo03primerspring.services;

import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

    private int value = 0;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}
