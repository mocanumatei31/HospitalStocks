package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Manufacturer;
import org.example.hospitalstocks.repositories.ManufacturerRepository;
import org.example.hospitalstocks.responsebodies.ManufacturerResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }
    public ManufacturerResponseBody getManufacturerById(String id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        Manufacturer manufacturer = optionalManufacturer.orElse(null);
        if (manufacturer == null) {
            return null;
        }
        return new ManufacturerResponseBody(manufacturer);
    }
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }
    public void deleteManufacturer(String id) {
        manufacturerRepository.deleteById(id);
    }

    public ManufacturerResponseBody findManufacturerByName(String name) {
        return new ManufacturerResponseBody(manufacturerRepository.findByNameLike(name));
    }
}
