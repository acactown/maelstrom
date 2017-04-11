package integration.jenkins.docker.jenkins_home.init.groovy.d

import hudson.model.*;
import jenkins.model.*;
import jenkins.install.InstallState;

import jenkins.*
import hudson.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import hudson.plugins.sshslaves.*;
import hudson.security.*

Thread.start {
    sleep 10000

    def jenkins = Jenkins.getInstance()
    def strategy = new GlobalMatrixAuthorizationStrategy()

    def hudsonRealm = new HudsonPrivateSecurityRealm(false)
    def adminUsername = System.getenv('JENKINS_USER') ?: 'admin'
    def adminPassword = System.getenv('JENKINS_PASS') ?: 'password'
    hudsonRealm.createAccount(adminUsername, adminPassword)

    jenkins.setSecurityRealm(hudsonRealm)
    jenkins.save()

//
////  Slave Permissions
//    strategy.add(hudson.model.Computer.BUILD,'anonymous')
//    strategy.add(hudson.model.Computer.CONFIGURE,'anonymous')
//    strategy.add(hudson.model.Computer.CONNECT,'anonymous')
//    strategy.add(hudson.model.Computer.CREATE,'anonymous')
//    strategy.add(hudson.model.Computer.DELETE,'anonymous')
//    strategy.add(hudson.model.Computer.DISCONNECT,'anonymous')
//
////  Credential Permissions
//    strategy.add(com.cloudbees.plugins.credentials.CredentialsProvider.CREATE,'anonymous')
//    strategy.add(com.cloudbees.plugins.credentials.CredentialsProvider.DELETE,'anonymous')
//    strategy.add(com.cloudbees.plugins.credentials.CredentialsProvider.MANAGE_DOMAINS,'anonymous')
//    strategy.add(com.cloudbees.plugins.credentials.CredentialsProvider.UPDATE,'anonymous')
//    strategy.add(com.cloudbees.plugins.credentials.CredentialsProvider.VIEW,'anonymous')
//
////  Overall Permissions
//    strategy.add(hudson.model.Hudson.ADMINISTER,'anonymous')
//    strategy.add(hudson.PluginManager.CONFIGURE_UPDATECENTER,'anonymous')
//    strategy.add(hudson.model.Hudson.READ,'anonymous')
//    strategy.add(hudson.model.Hudson.RUN_SCRIPTS,'anonymous')
//    strategy.add(hudson.PluginManager.UPLOAD_PLUGINS,'anonymous')
//
////  Job Permissions
//    strategy.add(hudson.model.Item.BUILD,'anonymous')
//    strategy.add(hudson.model.Item.CANCEL,'anonymous')
//    strategy.add(hudson.model.Item.CONFIGURE,'anonymous')
//    strategy.add(hudson.model.Item.CREATE,'anonymous')
//    strategy.add(hudson.model.Item.DELETE,'anonymous')
//    strategy.add(hudson.model.Item.DISCOVER,'anonymous')
//    strategy.add(hudson.model.Item.READ,'anonymous')
//    strategy.add(hudson.model.Item.WORKSPACE,'anonymous')
//
////  Run Permissions
//    strategy.add(hudson.model.Run.DELETE,'anonymous')
//    strategy.add(hudson.model.Run.UPDATE,'anonymous')
//
////  View Permissions
//    strategy.add(hudson.model.View.CONFIGURE,'anonymous')
//    strategy.add(hudson.model.View.CREATE,'anonymous')
//    strategy.add(hudson.model.View.DELETE,'anonymous')
//    strategy.add(hudson.model.View.READ,'anonymous')
//
////  Setting Anonymous Permissions
//    strategy.add(hudson.model.Hudson.READ,'anonymous')
//    strategy.add(hudson.model.Item.BUILD,'anonymous')
//    strategy.add(hudson.model.Item.CANCEL,'anonymous')
//    strategy.add(hudson.model.Item.DISCOVER,'anonymous')
//    strategy.add(hudson.model.Item.READ,'anonymous')
//    strategy.add(hudson.model.Hudson.ADMINISTER,'anonymous')
//    strategy.add(hudson.PluginManager.CONFIGURE_UPDATECENTER,'anonymous')
//    strategy.add(hudson.model.Hudson.RUN_SCRIPTS,'anonymous')
//    strategy.add(hudson.PluginManager.UPLOAD_PLUGINS,'anonymous')
//

    // Setting Admin Permissions
    strategy.add(Jenkins.ADMINISTER, "admin")

    def local = System.getenv("BUILD").toString()
    if(local == "local") {
        // Overall Permissions
        strategy.add(hudson.model.Hudson.ADMINISTER,'anonymous')
        strategy.add(hudson.PluginManager.CONFIGURE_UPDATECENTER,'anonymous')
        strategy.add(hudson.model.Hudson.READ,'anonymous')
        strategy.add(hudson.model.Hudson.RUN_SCRIPTS,'anonymous')
        strategy.add(hudson.PluginManager.UPLOAD_PLUGINS,'anonymous')
    }

    jenkins.setAuthorizationStrategy(strategy)
    jenkins.save()

    jenkins.setLabelString("master")
    jenkins.setNumExecutors(1)
    jenkins.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)

}
