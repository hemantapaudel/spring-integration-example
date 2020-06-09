package com.account.service.module;

import com.account.service.model.AccountResponse;

public interface AccountService {

    AccountResponse getAccountDetails(String id);
}
