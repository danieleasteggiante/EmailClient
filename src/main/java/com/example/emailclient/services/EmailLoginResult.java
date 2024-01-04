package com.example.emailclient.services;

/**
 * @author Daniele Asteggiante
 */
public enum EmailLoginResult {
    SUCCESS,
    FAILED_BY_CREDENTIALS,
    FAILED_BY_NETWORK,
    FAILED_BY_UNEXPECTED_ERROR;
}
