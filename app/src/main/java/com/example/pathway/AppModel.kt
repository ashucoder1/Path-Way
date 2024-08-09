package com.example.pathway

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

@OptIn(DelicateCoroutinesApi::class)
fun generateFunction(userInput:String,callback:(String)-> Unit){
    val text = "As a professional application developer with over a decade of experience in building various software applications, I am well-versed in creating sophisticated solutions tailored to meet $userInput needs. Your task today is to build a roadmap for a specific type of application. Please provide the following details for me to generate a comprehensive roadmap:" +
            "Name: ________" +
            "Project Description: ________" +
            "Tech Stacks: ________" +
            "User Flow: ________" +
            "Design Inspiration: ________" +
            "Resources for APIs: ________" +
            "Basic or Must-Have Features: ________" +
            "Goals: ________" +
            "Target Audience: ________" +
            "Project Schedule: ________" +
            "Risks and Solutions: ________" +
            "Additionally, please specify:" +
            "What is the best technology or framework for building this type of application?,i want you to give me data in this json format ,{" +
            "  applicationRoadmap: {" +
            "    name: string,                     " +
            "    projectDescription: string,       " +
            "    techStacks: {" +
            "      frontend: [" +
            "        string                          " +
            "      ]," +
            "      backend: [" +
            "        string                          " +
            "      ]," +
            "      database: [" +
            "        string                         " +
            "      ]," +
            "      otherTechnologies: [" +
            "        string                          " +
            "      ]" +
            "    }," +
            "    userFlow: [" +
            "      {" +
            "        stepNumber: integer,           " +
            "        description: string         " +
            "      }" +
            "    ]," +
            "    designInspiration: [" +
            "      {" +
            "        sourceName: string,           " +
            "        url: string                  " +
            "      }" +
            "    ]," +
            "    resourcesForAPIs: [" +
            "      {" +
            "        apiName: string,               " +
            "        documentationUrl: string     " +
            "      }" +
            "    ]," +
            "    basicOrMustHaveFeatures: [" +
            "      string                         " +
            "    ]," +
            "    goals: [" +
            "      string                  " +
            "    ]," +
            "    targetAudience: [" +
            "      string                      " +
            "    ]," +
            "    projectSchedule: [" +
            "      {" +
            "        phase: string,            " +
            "        duration: string           " +
            "      }" +
            "    ]," +
            "    risksAndSolutions: [" +
            "      {" +
            "        risk: string,             " +
            "        solution: string             " +
            "      }" +
            "    ],  bestTechnologyOrFramework: string " +
            "  }" +
            "}" + "note:atleast 4-6 frontend,backend,database and other technologies each are required.(give these details for many platforms ie web,android,ios and so on)"

    GlobalScope.launch(Dispatchers.IO) {
        try {
            val client = OkHttpClient()

            val MEDIA_TYPE = "application/json".toMediaType()

            val requestBody = """
        {
            "messages": [{"role": "user", "content": "$text"}],
            "model": "llama3-groq-70b-8192-tool-use-preview"
        }
    """.trimIndent()
            val request = Request.Builder()
                .url("https://api.groq.com/openai/v1/chat/completions")
                .post(requestBody.toRequestBody(MEDIA_TYPE))
                .header("Authorization", "Bearer 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")
                .header("Content-Type", "application/json")
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IOException("Unexpected code $response")
                }

                val responseBody = response.body?.string()

                // Update UI on the main thread
                withContext(Dispatchers.Main) {
                    val jsonObject = responseBody?.let { it1 -> JSONObject(it1) }
                    val messageContent = jsonObject?.getJSONArray("choices")?.getJSONObject(0)
                        ?.getJSONObject("message")?.getString("content")
                    //here message content is string and we need to convert it json object by gson
                    messageContent?.let {
                        val gson = Gson()
                        val content = gson.fromJson(messageContent, MessageContent::class.java)
                        GlobalState.applicationRoadmap=content.applicationRoadmap
                            withContext(Dispatchers.Main){
                                //Toast.makeText("Check Path Screen",Toast.LENGTH_SHORT).show()
                                callback(it)
                            }


                    }?:run {
                        withContext(Dispatchers.Main){
                            callback("Error:Parsing Failed")
                        }
                    }
                    //to show all data on search screen and Logcat
                    Log.d("TAG", "onCreate: $messageContent")
                }
            }
        } catch (e: Exception) {
            Log.e("TAG", "Error: ${e.message}", e)
            withContext(Dispatchers.Main){
                callback("Error:${e.message}")
            }
        }
    }
}


fun generateImage(term: String="circle", callback:(String?)-> Unit){
    //return url of image
    val API_KEY ="FPSXc8595407630a4b278d6229c177dbbef3"
    val client= OkHttpClient()
    val request= Request.Builder()
        .url("https://api.freepik.com/v1/resources?term=$term&filters%5Bcontent_type%5D%5Bvector%5D=1&order=relevance")
        .addHeader("Accept-Language","en-US")
        .addHeader("x-freepik-api-key",API_KEY)
        .build()

    client.newCall(request).enqueue(object :okhttp3.Callback{
        override fun onFailure(call: okhttp3.Call, e: IOException) {
            e.printStackTrace()
            callback(null)
        }
        override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
            if (response.isSuccessful){
                val responseData=response.body?.string()
                if (responseData!=null){
                    try {
                        val gson=Gson()
                        val apiResponse=gson.fromJson(responseData,ApiResponse::class.java)
                        if (apiResponse.data.isNotEmpty()) {
                            val vectorUrl = apiResponse.data[0].image.source.url
                            Log.d("TAG", "onResponse: $vectorUrl")
                            callback(vectorUrl)
                        }else{
                            callback(null)
                        }
                    }catch (e:Exception){
                        e.printStackTrace()
                        callback(null)
                    }
                }else{
                    callback(null)
                }
            }else {
                callback(null)
            }
        }
        })
}