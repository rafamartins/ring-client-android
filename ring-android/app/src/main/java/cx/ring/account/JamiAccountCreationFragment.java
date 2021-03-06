/*
 *  Copyright (C) 2004-2019 Savoir-faire Linux Inc.
 *
 *  Author: Adrien Béraud <adrien.beraud@savoirfairelinux.com>
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *   Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package cx.ring.account;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cx.ring.R;
import cx.ring.application.JamiApplication;
import cx.ring.databinding.FragAccRingCreateBinding;
import cx.ring.mvp.AccountCreationModel;
import cx.ring.mvp.BaseSupportFragment;
import cx.ring.utils.RegisteredNameFilter;

public class JamiAccountCreationFragment extends BaseSupportFragment<JamiAccountCreationPresenter>
        implements JamiAccountCreationView {

    private AccountCreationModel model;
    private FragAccRingCreateBinding binding;

    public static JamiAccountCreationFragment newInstance(AccountCreationModelImpl ringAccountViewModel) {
        JamiAccountCreationFragment fragment = new JamiAccountCreationFragment();
        fragment.model = ringAccountViewModel;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragAccRingCreateBinding.inflate(inflater, container, false);
        ((JamiApplication) getActivity().getApplication()).getInjectionComponent().inject(this);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        binding.ringUsername.setFilters(new InputFilter[]{new RegisteredNameFilter()});
        binding.ringPasswordSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            binding.ringPasswordBox.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            if (isChecked) {
                presenter.passwordChanged(binding.ringPassword.getText().toString(), binding.ringPasswordRepeat.getText().toString());
            } else {
                presenter.passwordUnset();
            }
        });
        binding.switchRingPush.setOnCheckedChangeListener((buttonView, isChecked) -> presenter.setPush(isChecked));
        binding.switchRingUsername.setOnCheckedChangeListener((buttonView, isChecked) -> presenter.registerUsernameChanged(isChecked));
        binding.createAccount.setOnClickListener(v -> presenter.createAccount());
        binding.ringPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.passwordChanged(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        binding.ringPasswordRepeat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.passwordConfirmChanged(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        binding.ringPasswordRepeat.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                presenter.createAccount();
            }
            return false;
        });
        binding.ringUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                presenter.userNameChanged(s.toString());
            }
        });

        presenter.init(model);
        presenter.setPush(binding.switchRingPush.isChecked());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (binding.ringUsernameBox.getVisibility() == View.VISIBLE) {
            binding.ringUsername.requestFocus();
            InputMethodManager imm = (InputMethodManager) requireActivity().
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(binding.ringUsername, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    @Override
    public void updateUsernameAvailability(UsernameAvailabilityStatus status) {
        binding.ringUsernameAvailabilitySpinner.setVisibility(View.GONE);
        //mUsernameAvailabilityImageView.setVisibility(View.VISIBLE);
        switch (status){
            case ERROR:
                binding.ringUsernameTxtBox.setErrorEnabled(true);
                binding.ringUsernameTxtBox.setError(getString(R.string.unknown_error));
                //mUsernameAvailabilityImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_error_red));
                binding.ringUsernameAvailabilityImageView.setVisibility(View.INVISIBLE);
                break;
            case ERROR_USERNAME_INVALID:
                binding.ringUsernameTxtBox.setErrorEnabled(true);
                binding.ringUsernameTxtBox.setError(getString(R.string.invalid_username));
                //mUsernameAvailabilityImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_error_red));
                binding.ringUsernameAvailabilityImageView.setVisibility(View.INVISIBLE);
                break;
            case ERROR_USERNAME_TAKEN:
                binding.ringUsernameTxtBox.setErrorEnabled(true);
                binding.ringUsernameTxtBox.setError(getString(R.string.username_already_taken));
                //mUsernameAvailabilityImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_error_red));
                binding.ringUsernameAvailabilityImageView.setVisibility(View.INVISIBLE);
                break;
            case LOADING:
                binding.ringUsernameTxtBox.setErrorEnabled(false);
                binding.ringUsernameAvailabilityImageView.setVisibility(View.INVISIBLE);
                binding.ringUsernameAvailabilitySpinner.setVisibility(View.VISIBLE);
                break;
            case AVAILABLE:
                binding.ringUsernameTxtBox.setErrorEnabled(false);
                binding.ringUsernameAvailabilityImageView.setVisibility(View.VISIBLE);
                binding.ringUsernameAvailabilityImageView.setImageDrawable(requireContext().getDrawable(R.drawable.ic_good_green));
                break;
            case RESET:
                binding.ringUsernameTxtBox.setErrorEnabled(false);
                binding.ringUsernameAvailabilityImageView.setVisibility(View.INVISIBLE);
                enableNextButton(false);
            default:
                binding.ringUsernameAvailabilitySpinner.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    public void showInvalidPasswordError(final boolean display) {
        if (display) {
            binding.passwordTxtBox.setError(getString(R.string.error_password_char_count));
        } else {
            binding.passwordTxtBox.setError(null);
        }
    }

    @Override
    public void showNonMatchingPasswordError(final boolean display) {
        if (display) {
            binding.ringPasswordRepeatTxtBox.setError(getString(R.string.error_passwords_not_equals));
        } else {
            binding.ringPasswordRepeatTxtBox.setError(null);
        }
    }

    @Override
    public void displayUsernameBox(final boolean display) {
        binding.ringUsernameBox.setVisibility(display ? View.VISIBLE : View.GONE);
    }

    @Override
    public void enableNextButton(final boolean enabled) {
        binding.createAccount.setEnabled(enabled);
    }

    @Override
    public void goToAccountCreation(AccountCreationModel accountCreationModel) {
        Activity wizardActivity = getActivity();
        if (wizardActivity instanceof AccountWizardActivity) {
            AccountWizardActivity wizard = (AccountWizardActivity) wizardActivity;
            wizard.createAccount(accountCreationModel);
        }
    }

    @Override
    public void cancel() {
        Activity wizardActivity = getActivity();
        if (wizardActivity != null) {
            wizardActivity.onBackPressed();
        }
    }

}
