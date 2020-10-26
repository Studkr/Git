package com.gitrepository.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GitModel(
        @JsonProperty("total_count")
        val totalCount: Long,
        @JsonProperty("incomplete_results")
        val incompleteResults: Boolean,
        val items: List<Item>
)

data class Item(
        val id: Long,
        @JsonProperty("node_id")
        val nodeID: String,
        val name: String,
        @JsonProperty("full_name")
        val fullName: String,
        val private: Boolean,
        val owner: Owner,
        @JsonProperty("html_url")
        val htmlURL: String,
        val description: String? = null,
        val fork: Boolean,
        val url: String,
        @JsonProperty("forks_url")
        val forksURL: String,
        @JsonProperty("keys_url")
        val keysURL: String,
        @JsonProperty("collaborators_url")
        val collaboratorsURL: String,
        @JsonProperty("teams_url")
        val teamsURL: String,
        @JsonProperty("hooks_url")
        val hooksURL: String,
        @JsonProperty("issue_events_url")
        val issueEventsURL: String,
        @JsonProperty("events_url")
        val eventsURL: String,
        @JsonProperty("assignees_url")
        val assigneesURL: String,
        @JsonProperty("branches_url")
        val branchesURL: String,
        @JsonProperty("tags_url")
        val tagsURL: String,
        @JsonProperty("blobs_url")
        val blobsURL: String,
        @JsonProperty("git_tags_url")
        val gitTagsURL: String,
        @JsonProperty("git_refs_url")
        val gitRefsURL: String,
        @JsonProperty("trees_url")
        val treesURL: String,
        @JsonProperty("statuses_url")
        val statusesURL: String,
        @JsonProperty("languages_url")
        val languagesURL: String,
        @JsonProperty("stargazers_url")
        val stargazersURL: String,
        @JsonProperty("contributors_url")
        val contributorsURL: String,
        @JsonProperty("subscribers_url")
        val subscribersURL: String,
        @JsonProperty("subscription_url")
        val subscriptionURL: String,
        @JsonProperty("commits_url")
        val commitsURL: String,
        @JsonProperty("git_commits_url")
        val gitCommitsURL: String,
        @JsonProperty("comments_url")
        val commentsURL: String,
        @JsonProperty("issue_comment_url")
        val issueCommentURL: String,
        @JsonProperty("contents_url")
        val contentsURL: String,
        @JsonProperty("compare_url")
        val compareURL: String,
        @JsonProperty("merges_url")
        val mergesURL: String,
        @JsonProperty("archive_url")
        val archiveURL: String,
        @JsonProperty("downloads_url")
        val downloadsURL: String,
        @JsonProperty("issues_url")
        val issuesURL: String,
        @JsonProperty("pulls_url")
        val pullsURL: String,
        @JsonProperty("milestones_url")
        val milestonesURL: String,
        @JsonProperty("notifications_url")
        val notificationsURL: String,
        @JsonProperty("labels_url")
        val labelsURL: String,
        @JsonProperty("releases_url")
        val releasesURL: String,
        @JsonProperty("deployments_url")
        val deploymentsURL: String,
        @JsonProperty("created_at")
        val createdAt: String,
        @JsonProperty("updated_at")
        val updatedAt: String,
        @JsonProperty("pushed_at")
        val pushedAt: String,
        @JsonProperty("git_url")
        val gitURL: String,
        @JsonProperty("ssh_url")
        val sshURL: String,
        @JsonProperty("clone_url")
        val cloneURL: String,
        @JsonProperty("svn_url")
        val svnURL: String,
        val homepage: String? = null,
        val size: Long,
        @JsonProperty("stargazers_count")
        val stargazersCount: Long,
        @JsonProperty("watchers_count")
        val watchersCount: Long,
        @JsonProperty("has_issues")
        val hasIssues: Boolean,
        @JsonProperty("has_projects")
        val hasProjects: Boolean,
        @JsonProperty("has_downloads")
        val hasDownloads: Boolean,
        @JsonProperty("has_wiki")
        val hasWiki: Boolean,
        @JsonProperty("has_pages")
        val hasPages: Boolean,
        @JsonProperty("forks_count")
        val forksCount: Long,
        @JsonProperty("mirrorURL")
        val mirrorURL: Any? = null,
        val archived: Boolean,
        val disabled: Boolean,
        @JsonProperty("open_issues_count")
        val openIssuesCount: Long,
        val license: License? = null,
        val forks: Long,
        @JsonProperty("open_issues")
        val openIssues: Long,
        val watchers: Long,
        @JsonProperty("default_branch")
        val defaultBranch: String,
        val score: Long
)



data class License(
        val key: String,
        val name: String,
        @JsonProperty("spdx_id")
        val spdxID: String,
        val url: String? = null,
        @JsonProperty("node_id")
        val nodeID: String
)

data class Owner(
        val login: String,
        val id: Long,
        @JsonProperty("node_id")
        val nodeID: String,
        @JsonProperty("avatar_url")
        val avatarURL: String,
        @JsonProperty("gravatar_id")
        val gravatarID: String,
        val url: String,
        @JsonProperty("html_url")
        val htmlURL: String,
        @JsonProperty("followers_url")
        val followersURL: String,
        @JsonProperty("following_url")
        val followingURL: String,
        @JsonProperty("gists_url")
        val gistsURL: String,
        @JsonProperty("starred_url")
        val starredURL: String,
        @JsonProperty("subscriptions_url")
        val subscriptionsURL: String,
        @JsonProperty("organizations_url")
        val organizationsURL: String,
        @JsonProperty("repos_url")
        val reposURL: String,
        @JsonProperty("events_url")
        val eventsURL: String,
        @JsonProperty("received_events_url")
        val receivedEventsURL: String,
        val type: Type,
        @JsonProperty("site_admin")
        val siteAdmin: Boolean
)

enum class Type {
    Organization,
    User
}