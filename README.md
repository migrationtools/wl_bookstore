This is a simple web application with JSP, Servlets and an in memory H2 Database.  The application is deployable on weblogic.
This web application is part of the puzzle as we explore automating the migration of applications from weblogic to tomcat.
This application will serve as a source war that we will use as the deployable that we want to migrate from weblogic to tomcat.
As of this commit, the only issue in this war that makes it incompatible with tomcat is the JNDI configuration.
If attempted to access the deployed war on tomcat, we will get a
java.lang.ClassNotFoundException: weblogic.jndi.WLInitialContextFactory

Next steps are for us to configure the Windup rules so that it can identify this issue and provide recommendation.  
Then, we need to see if we can automatically apply the recommendations and generate target deployable.
End product is a war that is expected to run on tomcat.
