Multithreaded Server Project
Robert Kiliszewski G00326038

This project allows the user to download the files from the donwloads folder after successfully connecting to the server on the port 7777. Each user is being instantiated as a new thread. I am using a blocking queue to sort the priority and do not make the users collide while downloading files at the same time. 