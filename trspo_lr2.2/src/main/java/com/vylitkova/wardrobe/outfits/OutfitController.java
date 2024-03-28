package com.vylitkova.wardrobe.outfits;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/outfits")
public class OutfitController {
    @Autowired
    private OutfitService outfitService;

    @GetMapping
    public ResponseEntity<List<Outfit>> getAllOutfits(){
        return new ResponseEntity<>(outfitService.allOutfit(), HttpStatus.OK);
    }

   @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Outfit>> getOutfitById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(outfitService.singleOutfitById(id), HttpStatus.OK);
    }
    @GetMapping("/findBySeason/{season}")
    public ResponseEntity<List<Outfit>> getOutfitsBySeason(@PathVariable String season) {
        return new ResponseEntity<>(outfitService.outfitsBySeason(season), HttpStatus.OK);
    }

    @GetMapping("/findByStyle/{style}")
    public ResponseEntity<List<Outfit>> getOutfitsByStyle(@PathVariable String style) {
        return new ResponseEntity<>(outfitService.outfitsByStyle(style), HttpStatus.OK);
    }

    @GetMapping("/findByMood/{mood}")
    public ResponseEntity<List<Outfit>> getOutfitsByMood(@PathVariable String mood) {
        return new ResponseEntity<>(outfitService.outfitsByMood(mood), HttpStatus.OK);
    }

    @GetMapping("/findByColor/{color}")
    public ResponseEntity<List<Outfit>> getOutfitsByColor(@PathVariable String color) {
        return new ResponseEntity<>(outfitService.outfitsByColor(color), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addOutfit(@RequestBody Outfit outfit){
        return ResponseEntity.ok(outfitService.save(outfit));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOutfitLike(@PathVariable ObjectId id, @RequestBody Outfit outfit ) {
        return  ResponseEntity.ok(outfitService.updateLike(id, outfit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteOutfit(@PathVariable ObjectId id){
        return ResponseEntity.ok(outfitService.deleteById(id));
    }


}
