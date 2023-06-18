package com.example.submissionawal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionawal.databinding.FragmentFollowBinding

class FollowingFragment : Fragment(R.layout.fragment_follow) {

    private var _binding: FragmentFollowBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FollowingViewModel
    private lateinit var adapterGit: AdapterGit
    private lateinit var username: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var args = arguments
        username = args?.getString(DetailUsersActivity.EXTRA_USERNAME).toString()
        _binding = FragmentFollowBinding.bind(view)

        adapterGit = AdapterGit()
        adapterGit.notifyDataSetChanged()

        binding.apply {
            rvGit.setHasFixedSize(true)
            rvGit.layoutManager = LinearLayoutManager(activity)
            rvGit.adapter = adapterGit
        }

        showLoading(true)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[FollowingViewModel::class.java]
        viewModel.setFollowingList(username)
        viewModel.getFollowingList().observe(viewLifecycleOwner) {
            if (it != null) {
                adapterGit.setUser(it)
                showLoading(false)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showLoading(state: Boolean) {
        binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
    }

}