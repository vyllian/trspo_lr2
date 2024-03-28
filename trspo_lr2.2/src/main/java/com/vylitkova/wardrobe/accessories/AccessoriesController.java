package com.vylitkova.wardrobe.accessories;


import com.vylitkova.wardrobe.clothes.Clothes;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/accessories")
public class AccessoriesController {
    @Autowired
    private AccessoriesService accessoriesService;

    @GetMapping
    public ResponseEntity<List<Accessories>> getAllAccessories(){
        return ResponseEntity.ok(accessoriesService.allAccessories());
    }
    @GetMapping("/findByColor/{color}")
    public ResponseEntity<List<Accessories>> getByColor(@PathVariable String color){
        return new ResponseEntity<>(accessoriesService.allByColor(color), HttpStatus.OK);
    }
    @GetMapping("/{type}")
    public ResponseEntity<List<Accessories>> getByType(@PathVariable String type){
        return new ResponseEntity<>(accessoriesService.allByType(type), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Accessories>> getAccessoryById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(accessoriesService.accessoryById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAccessory(@RequestBody Accessories accessory){
        return ResponseEntity.ok(accessoriesService.save(accessory));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteOutfit(@PathVariable ObjectId id){
        return ResponseEntity.ok(accessoriesService.deleteById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategoryType(@PathVariable ObjectId id, @RequestBody Accessories accessories) {
        return new ResponseEntity<>(accessoriesService.updateTypeById(id, accessories), HttpStatus.OK);
    }
}
