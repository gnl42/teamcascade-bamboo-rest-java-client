# BRJC
![BRJC][1]

What is BRJC?
------------------------

The Bamboo REST Java Client (BRJC) library is inspired by the design and code of the JIRA REST Java Client (JRJC) from Atlassian.
This library arose from the need to also access easily the REST endpoints of the Bamboo Continuous Integration Server in as easy a manner as provided
by the JRJC in one of our projects.

Although accessing the REST endpoints via other Java libraries like Jackson/GSon/etc would have been easier we decided that the JIRC approach was more 
developper friendly in the long run and are thus attempring to provide a similar functionality.


Who is TeamCascade?
-------------------

TeamCascade is the team behind the different projects originating from TeamCascade, we work together on our plugins, sometimes as a team, sometimes as one developer with some helping hands.

| ![Don Redhorse][10]   | ![Duck][11]   |
| Don Redhorse  | Dukmeister    |

Visit our [website][2].
Track and submit issues and bugs on our [issue tracker][3].

Source
------
The latest and greatest source can be found on [BitBucket][4]
Download the latest builds from [Bamboo][5].
You can get maven artifacts from [Artifactory][6].
And you will find the documentation in our [Doxygen Repo][7]

License
-------
BRJC is licensed under Apache License Version 2.0

Compiling
---------
BRJC uses Maven to handle its dependencies.

* Install [Maven 2 or 3](http://maven.apache.org/download.html)
* Checkout this repo and run: `mvn clean package install`

Coding Standards
----------------------------------
* If / for / while / switch statement: if (conditions && stuff) {
* Method: public void method(Object paramObject) {
* No Spaces, Tab is preferred!
* No trailing whitespace
* Mid-statement newlines at a 200 column limit
* camelCase, no under_scores except constants
* Constants in full caps with underscores
* Keep the same formatting style everywhere
* You can use the TeamCascadeCodeScheme.xml to implement our coding formatting style in most IDE

Pull Request Standards
----------------------------------
* Sign-off on all commits!
* Finished product must compile successfully with `mvn`!
* No merges should be included in pull requests unless the pull request's purpose is a merge.
* Number of commits in a pull request should be kept to *one commit* and all additional commits must be *squashed*. Pull requests that make multiple changes should have one commit per change.
* Pull requests must include any applicable license headers. (These are generated when running `mvn clean`)

[1]: http://www.teamcascade.org/plugins/servlet/zenfoundation/zenservlet/designs/brands/tc-alpha1/images/logo1.png
[2]: http://www.teamcascade.org
[3]: http://issues.teamcascade.org
[4]: https://bitbucket.org/teamcascade/${project.name}
[5]: http://builds.teamcascade.org
[6]: http://artifacts.teamcascade.org
[7]: http://docs.teamcascade.org
[8]: http://www.teamcascade.org/display/AboutUs/TeamCascade+Public+License
[10]: http://www.gravatar.com/avatar/5715022800b638db4951afe80841b314.png?size=55
[11]: https://dl.dropbox.com/u/userid/file.png

