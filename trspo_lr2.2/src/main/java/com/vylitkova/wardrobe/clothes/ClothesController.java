package com.vylitkova.wardrobe.clothes;

import com.vylitkova.wardrobe.outfits.Outfit;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/clothes")
public class ClothesController {
    @Autowired
    private ClothesService clothesService;

    @GetMapping
    public ResponseEntity<List<Clothes>> getAllClothes(){
        return new ResponseEntity<>(clothesService.allClothes(), HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Clothes>> getClothesByCategory(@PathVariable String category) {return new ResponseEntity<>(clothesService.clothesByCategory(category),HttpStatus.OK);}

    @GetMapping("/category/{type}")
    public ResponseEntity<List<Clothes>> getByType(@PathVariable String type) {return new ResponseEntity<>(clothesService.clothesByType(type ), HttpStatus.OK);}

    @GetMapping("/findByColor/{color}")
    public ResponseEntity<List<Clothes>> getClothesByColor(@PathVariable String color) {
        return new ResponseEntity<>(clothesService.clothesByColor(color), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Clothes>> getClothesById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(clothesService.clothesById(id), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategoryType(@PathVariable ObjectId id, @RequestBody Clothes clothes) {
        return new ResponseEntity<>(clothesService.update(clothes, id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCloth(@RequestBody Clothes clothes){
        return ResponseEntity.ok(clothesService.save(clothes));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteCloth(@PathVariable ObjectId id){
        return ResponseEntity.ok(clothesService.deleteById(id));
    }



}
