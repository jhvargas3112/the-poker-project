package com.poker.project.multimodule.base.mazos.exceptions;

@SuppressWarnings("serial")
public class CardIsInTheDeckException extends Exception {
	public CardIsInTheDeckException(String message) {
		super(message);
	}
}
