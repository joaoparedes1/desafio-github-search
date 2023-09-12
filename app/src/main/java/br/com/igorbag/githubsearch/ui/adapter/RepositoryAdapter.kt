package br.com.igorbag.githubsearch.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import br.com.igorbag.githubsearch.ui.MainActivity

class RepositoryAdapter(private val repositories: List<Repository>, context: Context) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var cardListener: (Repository) -> Unit = {}
    var shareListener: (Repository) -> Unit = {}

    private var context: Context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.repositorio.text = repositories[position].name

        holder.card.setOnClickListener {
            cardListener(repositories[position])
        }

        holder.share.setOnClickListener {
            shareListener(repositories[position])
        }
    }
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val repositorio: TextView
        val share: ImageView
        val card: CardView

        init {
            view.apply {
                repositorio = findViewById(R.id.tv_repo)
                share = findViewById(R.id.iv_share)
                card = findViewById(R.id.cv_card)
            }
        }
    }
}


