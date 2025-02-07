package com.example.jpa1.service;

import com.example.jpa1.dto.MemoRequestDto;
import com.example.jpa1.dto.MemoResponseDto;
import com.example.jpa1.entity.Memo;
import com.example.jpa1.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponseDto save(MemoRequestDto memoRequestDto) {

        Memo memo = new Memo(memoRequestDto.getTitle(), memoRequestDto.getContent());
        memoRepository.save(memo);

        return new MemoResponseDto(memo.getId(), memo.getTitle(), memo.getContent());
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> findAll(){
        List<Memo> memos = memoRepository.findAll();

        List<MemoResponseDto> dtos = new ArrayList<>();

        for (Memo memo : memos) {
            dtos.add(new MemoResponseDto(memo.getId(), memo.getTitle(), memo.getContent()));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public MemoResponseDto findById(Long id){
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("id가 없습니다."));

        return new MemoResponseDto(memo.getId(), memo.getTitle(), memo.getContent());
    }

    @Transactional
    public MemoResponseDto update(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당에 맞는 메모가 없습니다."));

        memo.update(memo.getTitle(), memo.getContent());

        return new MemoResponseDto(memo.getId(), memo.getTitle(), memoRequestDto.getContent());
    }

    @Transactional
    public void delete(Long id){
        memoRepository.deleteById(id);
    }
}
