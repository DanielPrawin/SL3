def newGit(Repo)
{
  git "https://github.com/DanielPrawin/${Repo}.git"
}
def build()
{
  sh "mvn package"
}
def deploy(jobName,id,context)
{
 sh "scp /var/lib/jenkins/workspace/${jobName}/webapp/target/webapp.war ubuntu@${id}:/var/lib/tomcat9/webapps/${context}.war"
}
def testing(jobName)
{
  sh 'java -jar /var/lib/jenkins/workspace/${jobName}/testing.jar'
}
