# Maelstrom

## Purpose
Maelstrom is a reusable pipeline that achieves operational improvements as well as increasing confidence, security, quality and speed of software we build by providing a deterministic, standardised and flexible Continuous Integration/Delivery process. Kubernetes is the primary focus of Maelstrom, however, Maelstrom is extensible and works with any tech stack.

## Execution
### Through Jenkins integration

In order to try out the pipeline in a Jenkins instance, you can do it easily with a dockerized Jenkins. There's already one in this repo, configured with the minimum things it requires to run, and it counts with a sample job. To spin up the dockerized Jenkins service, run
`sh integration jenkins clean-run`

Once it's up and running, you can go to [http://localhost:8080/job/job-template](http://localhost:8080/job/job-template) to check it out

### Detached execution

The detached execution allows you to run the pipeline locally, without Jenkins integration. This means it will run the different stages locally. To do a detached execution run
`sh integration local clean-run`
