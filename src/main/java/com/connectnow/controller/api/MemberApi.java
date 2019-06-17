package com.connectnow.controller.api;

import com.connectnow.constant.ApiConstant;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.dto.MemberDto;
import com.connectnow.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Map;

@RestController
@RequestMapping(value = ApiConstant.API_MEMBER_URL)
public class MemberApi {

    private final Logger logger = LoggerFactory.getLogger(MemberApi.class);
    private final MemberService memberService;

    @Autowired
    public MemberApi(MemberService memberService) {
        this.memberService = memberService;
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity updateReadStatus(@RequestBody Map<String, Object> data) {
        try {
            BigInteger memberId = new BigInteger(data.get("memberId").toString());
            boolean readStatus = (boolean) data.get("readStatus");
            this.memberService.updateReadStatusByMemberId(memberId, readStatus);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping
    @ResponseBody
    public MemberDto create(@RequestBody MemberDto memberDto) {
        try {
            return memberService.save(memberDto);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
