package com.garam.professionalData.viewModel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.garam.professionalData.BuildConfig
import com.garam.professionalData.adapter.RecyclerAdapter
import com.garam.professionalData.data.ItemInfoData
import com.garam.professionalData.data.ResponseData
import com.garam.professionalData.network.NetworkController
import com.garam.professionalData.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProDataViewModel(application: Application) : AndroidViewModel(application) {

    private val networkService : NetworkService by lazy {
        NetworkController.instance.networkService
    }

    val searchWord = MutableLiveData<String>()
    val proData = ObservableArrayList<ItemInfoData>()

    fun search(recyclerView: RecyclerView) {
        (recyclerView.adapter as RecyclerAdapter).items.clear()
        networkService.search(BuildConfig.naver_client_id, BuildConfig.naver_client_secret, searchWord.value.toString())
            .enqueue(
                object : Callback<ResponseData> {
                    override fun onFailure(call: Call<ResponseData>, t: Throwable) {

                    }

                    override fun onResponse(
                        call: Call<ResponseData>,
                        response: Response<ResponseData>
                    ) {
                        val res = response.body()!!
                        val size = res.display
                        repeat(size) {
                            val title = res.items[it].title.replace("&lt;","<").replace("&gt;",">")
                                .replace("<b>","").replace("</b>","")
                            val description = res.items[it].description.replace("&lt;","<").replace("&gt;",">")
                                .replace("<b>","").replace("</b>","")
                            proData.add(ItemInfoData(title,res.items[it].link,description))
                        }
                    }
                })
    }
}