package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.BrandProductCountDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Brand;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public List<BrandProductCountDto> getAllProductCountDto(){
        return brandRepository.getAllProductCountDto();
    }

    @Override
    public Optional<BigDecimal> getAveragePrice(String brandId) {
        return brandRepository.getAveragePrice(brandId);
    }
}
