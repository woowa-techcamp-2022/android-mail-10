package com.nimok97.mailproject.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nimok97.mailproject.R
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.databinding.FragmentSettingBinding
import com.nimok97.mailproject.ui.MainViewModel
import com.nimok97.mailproject.ui.util.BottomNavigationFragmentType
import com.nimok97.mailproject.ui.util.BottomNavigationFragmentTypeService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment(), BottomNavigationFragmentTypeService {

    private lateinit var binding: FragmentSettingBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PrintLog.printLog("$this / onCreateView")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PrintLog.printLog("$this / onViewCreated")

        updateCurrentBottomNavigationFragmentType()

        initView()
    }

    override fun updateCurrentBottomNavigationFragmentType() {
        viewModel.updateCurrentBottomNavigationFragmentType(BottomNavigationFragmentType.SETTING)
    }

    private fun initView() {
        binding.editTextNickname.setText(viewModel.information.nickName)
        binding.editTextEmail.setText(viewModel.information.email)
    }
}