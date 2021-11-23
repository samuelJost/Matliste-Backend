package ch.sjost.jsobra.matliste.controller;

import ch.sjost.jsobra.matliste.exceptions.MaterialNotFoundException;
import ch.sjost.jsobra.matliste.model.Material;
import ch.sjost.jsobra.matliste.repositories.MaterialRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterialController {
    private final MaterialRepository materialRepository;

    MaterialController(MaterialRepository materialRepository){
        this.materialRepository = materialRepository;
    }

    @GetMapping("/materials")
    List<Material> all(){
        return materialRepository.findAll();
    }

    @PostMapping("/materials")
    Material newMaterial(@RequestBody Material newMaterial) {
        return materialRepository.save(newMaterial);
    }

    @GetMapping("materials/{id}")
    Material one(@PathVariable Long id){
        return materialRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException(id));
    }

    @PutMapping("/materials/{id}")
    Material replaceMaterial(@RequestBody Material newMaterial, @PathVariable Long id) {
        return materialRepository.findById(id)
                .map(material -> {
                    material.setTitle(newMaterial.getTitle());
                    material.setCategory(newMaterial.getCategory());
                    material.setAmountOf(newMaterial.getAmountOf());
                    material.setStoringPlace(newMaterial.getStoringPlace());
                    material.setDescription(newMaterial.getDescription());
                    return materialRepository.save(material);
                })
                .orElseGet(() -> {
                    newMaterial.setId(id);
                    return materialRepository.save(newMaterial);
                });
    }

    @DeleteMapping("/materials/{id}")
    void deleteMaterial(@PathVariable Long id){
        materialRepository.deleteById(id);
    }
}
