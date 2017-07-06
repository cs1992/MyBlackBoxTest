package com.test.blackbox.action;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.test.blackbox.model.MailResponseDto;

public interface Action {
    MailResponseDto execute(ModelAndView model);
}
