package com.example.jpa1.controller;


import com.example.jpa1.dto.MemoRequestDto;
import com.example.jpa1.dto.MemoResponseDto;
import com.example.jpa1.entity.Memo;
import com.example.jpa1.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<MemoResponseDto> save(@RequestBody MemoRequestDto memoRequestDto){
        return ResponseEntity.ok(memoService.save(memoRequestDto));
    }

    @GetMapping("/memos")
    public ResponseEntity<List<MemoResponseDto>> findAll() {
        return ResponseEntity.ok(memoService.findAll());
    }

    @GetMapping("/memos/{id}")
    public ResponseEntity<MemoResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(memoService.findById(id));
    }

    @PutMapping("/memos/{id}")
    public ResponseEntity<MemoResponseDto> update(@PathVariable Long id,
                                                  @RequestBody MemoRequestDto memoRequestDto){
        return ResponseEntity.ok(memoService.update(id, memoRequestDto));
    }

    @DeleteMapping("/memos/{id}")
    public void delete(@PathVariable Long id){
        memoService.delete(id);
    }
}
