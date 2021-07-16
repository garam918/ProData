package com.garam.professionalData.viewModel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import com.garam.professionalData.BuildConfig
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

    val proData = ObservableArrayList<ItemInfoData>()

    fun search() {
        networkService.search(BuildConfig.naver_client_id, BuildConfig.naver_client_secret, "주식")
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
                            proData.add(ItemInfoData(res.items[it].title,res.items[it].link,res.items[it].description))
                        }
                    }
                })
    }

}