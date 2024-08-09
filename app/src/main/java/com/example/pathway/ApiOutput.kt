package com.example.pathway

data class ApplicationRoadmap(
    val name: String,
    val projectDescription: String,                        // Description of the project
    val techStacks: TechStacks,
    val userFlow: List<UserFlowStep>,
    val designInspiration: List<DesignInspiration>,
    val resourcesForAPIs: List<ResourceAPI>,
    val basicOrMustHaveFeatures: List<String>,
    val goals: List<String>,                               // List of project goals
    val targetAudience: List<String>,                      // List of target audiences
    val projectSchedule: List<ProjectSchedulePhase>,       // Schedule for the project
    val risksAndSolutions: List<RiskAndSolution>,          // List of risks and their solutions
    val bestTechnologyOrFramework: String
)

data class TechStacks(
    val frontend: List<String>,
    val backend: List<String>,
    val database: List<String>,
    val otherTechnologies: List<String>
)

data class UserFlowStep(
    val stepNumber: Int,
    val description: String
)

data class DesignInspiration(
    val sourceName: String,
    val url: String
)

data class ResourceAPI(
    val apiName: String,
    val documentationUrl: String
)

data class ProjectSchedulePhase(
    val phase: String,                                     // Name of the project phase
    val duration: String                                   // Duration of the phase (e.g., "1 month")
)

data class RiskAndSolution(
    val risk: String,                                      // Description of the risk
    val solution: String                                   // Possible solution to the risk
)

data class MessageContent(
    val applicationRoadmap: ApplicationRoadmap
)

object GlobalState {
    var applicationRoadmap: ApplicationRoadmap? = null
}

