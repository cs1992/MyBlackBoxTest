package com.test.blackbox.action;

import org.springframework.ui.Model;

public interface Action {
	String execute(Model model);
}
