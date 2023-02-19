import fs
import requests
import json

url = "https://gist.github.com/trulicups/5f104008d4fb52a3574c2e8dfc92b845"

if __name__ == '__main__':
    response = requests.get(url=url)

    if(response.ok):
        with open("./restful_client/sample_response.html", "wb") as fs:
            fs.write(response.content)

    else:
        response.raise_for_status()