package my.rockpilgrim.chucknorriskotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.jokes_fragment.*
import my.rockpilgrim.chucknorriskotlin.adapters.JokeAdapter
import my.rockpilgrim.chucknorriskotlin.data.Event
import my.rockpilgrim.chucknorriskotlin.data.pogo.Joke
import my.rockpilgrim.chucknorriskotlin.databinding.JokesFragmentBinding
import my.rockpilgrim.chucknorriskotlin.viewModels.MainViewModel

class JokeFragment : Fragment() {

//    private val mainViewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    private lateinit var mainViewModel: MainViewModel
    val adapter = JokeAdapter()



    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = JokesFragmentBinding.inflate(inflater, container, false)

        binding.viewModel = mainViewModel
        binding.adapter=adapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecycler()
        initRefresh()
    }

    fun initRefresh() {
        refreshView.setOnRefreshListener {
            mainViewModel.loadJokes()
        }
    }

    private fun initRecycler() {
//        val adapter = JokeAdapter()

//        jokeRecyclerView.adapter = adapter
        subscribeUI(adapter)
    }

    private fun subscribeUI(
        adapter: JokeAdapter) {
        mainViewModel.jokeList.observe(viewLifecycleOwner, Observer {event ->
            when (event) {
                is Event.Success -> success(jokes = event.jokes, adapter = adapter)
                is Event.Error -> error(message = event.message)
                Event.Loading -> loading()
            }
        })
    }

    private fun loading() {
        stateTextView.text = getString(R.string.loading)
        refreshView.isRefreshing = true
    }

    private fun success(jokes: List<Joke>, adapter: JokeAdapter) {
        stateTextView.text = getString(R.string.success)
        adapter.submitList(jokes)
        refreshView.isRefreshing=false
    }

    private fun error(message:String) {
        stateTextView.text = getString(R.string.error)
        refreshView.isRefreshing=false
    }
}