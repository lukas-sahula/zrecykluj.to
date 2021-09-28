package vinencoding.zrecyklujto

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vinencoding.zrecyklujto.adapters.RecyclingCodeItemsAdapter
import vinencoding.zrecyklujto.models.RecyclingCode
import vinencoding.zrecyklujto.utils.Constants


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [DecisionTreeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DecisionTreeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_decision_tree, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_recycling_code_list)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)

        val adapter = RecyclingCodeItemsAdapter(view.context, Constants.getDecisionTreeCardInformation())
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object:
            RecyclingCodeItemsAdapter.OnClickListener{
            override fun onClick(position: Int, model: RecyclingCode) {
                when (model.materialType) {
                        "Pl" -> view.findNavController().navigate(R.id.plasticFragment)
                        "Pa" -> view.findNavController().navigate(R.id.paperFragment)
                        "Me" -> view.findNavController().navigate(R.id.metalFragment)
                        "Gl" -> view.findNavController().navigate(R.id.glassFragment)
                        "Te" -> view.findNavController().navigate(R.id.tetrapackFragment)
                        "Va" -> view.findNavController().navigate(R.id.otherMaterialFragment)
                    }
                }
            })

        return view
    }





companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DecisionTreeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DecisionTreeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}