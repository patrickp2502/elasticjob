# elasticjob
Given Job Descriptions beeing searched by tag values. The job document will be flagged with that given tag, if it is a hit.
This small service uses a elasticsearch instance.
On service startup, there will be a set of data created. Change the
count in the application.properties.

## TaggingService
The tagging service searches for a given tag, by using a ElasticsearchRepository.
The documents will be flagged, based on the tag list (set via application.properties)

## docker image used for elasticsearch
```
docker run -p 9200:9200 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.0
```

## deleting elasticsearch index
``` 
curl -X DELETE 'http://localhost:9200/job'
```

## todo: 
- testing
- multilevel taging 
