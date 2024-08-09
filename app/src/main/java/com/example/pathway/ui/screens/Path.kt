package com.example.pathway.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pathway.DrawLine
import com.example.pathway.GlobalState
import com.example.pathway.ShowData2
import com.example.pathway.ShowDesignInspirationApi
import com.example.pathway.ShowFeatureList
import com.example.pathway.ShowProjectSchedule
import com.example.pathway.ShowRiskAndSolution
import com.example.pathway.ShowUserFlow

@Composable
fun PathScreen() {
    val scrollState = rememberScrollState()
    val applicationRoadmap = GlobalState.applicationRoadmap

    //APP name and description
    var name = applicationRoadmap?.name ?: "Error"
    var description = applicationRoadmap?.projectDescription ?: ""

    //goals
    val goalsSize = applicationRoadmap?.goals?.size ?: 0
    val goalsList = mutableListOf<String>()
    for (i in 0 until goalsSize) {
        applicationRoadmap?.goals?.getOrNull(i)?.let {
            goalsList.add(it)
        }
    }

    //target audience
    val targetAudienceSize = applicationRoadmap?.targetAudience?.size ?: 0
    val targetAudienceList = mutableListOf<String>()
    for (i in 0 until targetAudienceSize) {
        applicationRoadmap?.targetAudience?.getOrNull(i)?.let {
            targetAudienceList.add(it)
        }
    }


    //tech Stack
    val frontendSize = applicationRoadmap?.techStacks?.frontend?.size ?: 0
    val frontendList = mutableListOf<String>()
    // Iterate over the list and store the values in techStacksList
    for (i in 0 until frontendSize) {
        applicationRoadmap?.techStacks?.frontend?.getOrNull(i)?.let {
            frontendList.add(it)
        }
    }

    val backendSize = applicationRoadmap?.techStacks?.backend?.size ?: 0
    val backendList = mutableListOf<String>()
    for (i in 0 until backendSize) {
        applicationRoadmap?.techStacks?.backend?.getOrNull(i)?.let {
            backendList.add(it)
        }
    }

    val databaseSize = applicationRoadmap?.techStacks?.database?.size ?: 0
    val databaseList = mutableListOf<String>()
    for (i in 0 until databaseSize) {
        applicationRoadmap?.techStacks?.database?.getOrNull(i)?.let {
            databaseList.add(it)
        }
    }
    val otherSize = applicationRoadmap?.techStacks?.otherTechnologies?.size ?: 0
    val otherList = mutableListOf<String>()
    for (i in 0 until otherSize) {
        applicationRoadmap?.techStacks?.otherTechnologies?.getOrNull(i)?.let {
            otherList.add(it)
        }
    }
    //User Flow
    val userFlowSize = applicationRoadmap?.userFlow?.size ?: 0
    val userFlowList = mutableListOf<String>()
    for (i in 0 until userFlowSize) {
        applicationRoadmap?.userFlow?.getOrNull(i)?.let {
            userFlowList.add(it.description)
        }
    }

    //Design Inspiration
    val designInspirationSize = applicationRoadmap?.designInspiration?.size ?: 0
    val designInspirationList = mutableListOf<String>()
    val designInspirationUrlList = mutableListOf<String>()
    for (i in 0 until designInspirationSize) {
        applicationRoadmap?.designInspiration?.getOrNull(i)?.let {
            designInspirationList.add(it.sourceName)
            designInspirationUrlList.add(it.url)
        }
    }

    //API Resource
    val apiSize = applicationRoadmap?.resourcesForAPIs?.size ?: 0
    val apiList = mutableListOf<String>()
    val apiUrlList = mutableListOf<String>()
    for (i in 0 until apiSize) {
        applicationRoadmap?.resourcesForAPIs?.getOrNull(i)?.let {
            apiList.add(it.apiName)
            apiUrlList.add(it.documentationUrl)
        }
    }

    //Feature list
    val featureSize = applicationRoadmap?.basicOrMustHaveFeatures?.size ?: 0
    val featureList = mutableListOf<String>()
    for (i in 0 until featureSize) {
        applicationRoadmap?.basicOrMustHaveFeatures?.getOrNull(i)?.let {
            featureList.add(it)
        }
    }

    //project schedule
    var scheduleSize = applicationRoadmap?.projectSchedule?.size ?: 0
    var phaseList = mutableListOf<String>()
    var durationList = mutableListOf<String>()
    for (i in 0 until scheduleSize) {
        applicationRoadmap?.projectSchedule?.getOrNull(i)?.let {
            phaseList.add(it.phase)
            durationList.add(it.duration)
        }
    }

    //risk and solution
    var riskSize = applicationRoadmap?.risksAndSolutions?.size ?: 0
    var riskList = mutableListOf<String>()
    var solutionList = mutableListOf<String>()
    for (i in 0 until riskSize) {
        applicationRoadmap?.risksAndSolutions?.getOrNull(i)?.let {
            riskList.add(it.risk)
            solutionList.add(it.solution)
        }
    }

    //best tech
    var bestTech = applicationRoadmap?.bestTechnologyOrFramework ?: "No tech stack"

    if(name=="Error"){
        Box(modifier = Modifier.fillMaxSize().padding(start = 8.dp),
            contentAlignment = Alignment.Center){
            Text(text = "Try Searching For a App type in Search Screen")
        }
    }else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp, end = 8.dp, bottom = 32.dp)
                .verticalScroll(rememberScrollState())
        )
        {
            Text(
                text = name,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp).align(Alignment.End)
            )
            Text(
                text = description,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(bottom = 16.dp).align(Alignment.Start)
            )

            Text(text = "Goals:",
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp)
            )
            ShowFeatureList(listItems = goalsList)


            Text(text = "Target Audience:", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowFeatureList(listItems = targetAudienceList)


            Text(text = "Project Schedule:", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowProjectSchedule(listItems1 = durationList, listItems2 = phaseList)

            Text(text = "Front-End Technologies", fontSize = 24.sp, modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowData2(
                listItems = frontendList,
                imageUrl = "https://plus.unsplash.com/premium_photo-1721276303391-ee0af231d021?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            )


            Text(text = "Back-End Technologies", fontSize = 24.sp, modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowData2(
                listItems = backendList,
                imageUrl = "https://plus.unsplash.com/premium_photo-1721276303391-ee0af231d021?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            )

            Text(text = "DataBase Technologies", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowData2(
                listItems = databaseList,
                imageUrl = "https://plus.unsplash.com/premium_photo-1721276303391-ee0af231d021?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            )

            Text(text = "Other Technologies", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowData2(
                listItems = otherList,
                imageUrl = "https://plus.unsplash.com/premium_photo-1721276303391-ee0af231d021?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            )

            Text(text = "User Flow of the Application:", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowUserFlow(listItems = userFlowList)
            Text(text = "App Completed", fontSize = 18.sp, modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 16.dp))


            Text(text = "Design Inspirations", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowDesignInspirationApi(
                listItems1 = designInspirationList,
                listItems2 = designInspirationUrlList
            )

            Text(text = "Resources for APIs", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowDesignInspirationApi(listItems1 = apiList, listItems2 = apiUrlList)

            Text(text = "Basic or Must-Have Features", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowFeatureList(listItems = featureList)

            Text(text = "Best Technology or Framework", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            Text(text = bestTech, fontSize = 18.sp, modifier = Modifier.padding(bottom = 16.dp))

            Text(text = "Risk and Solutions", fontSize = 24.sp,modifier = Modifier.align(Alignment.Start).padding(bottom = 8.dp))
            ShowRiskAndSolution(listItems1 = riskList, listItems2 = solutionList)

        }
    }
}
