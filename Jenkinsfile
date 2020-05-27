node{
	stage ('scm checkout') {
		git 'https://github.com/cmcsoftware/read-microservice'
	}
	stage ('Checkout to different branch') {
		sh "git branch -r"
		sh "git checkout master"
	}
	stage ('package stage') {
		sh label: '', script: 'mvn clean package'
	}
	
	stage ('docker image build') {
		sh 'docker build -t bunicool/read-microservice .'
	}
	stage ('docker image run') {
		sh 'docker run -d -p 8082:8080 --name read bunicool/read-microservice'
	}
	
}	
