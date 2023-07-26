import requests


def indeed_request():
    # TODO 2: Put the code from the Postman steps of the lab here.
    # - Make sure you used the correct URL
    # - Also, erase any unnecessary code like the import statement
    pass # Replace this line with your code
    

    url = "https://www.indeed.com/jobs?q=Software Engineer&l=Charlotte"

    payload = {}
    headers = {
    'Cookie': '__cf_bm=5PoKERIcXkVnb_0tdLXCThJEiSEi34pyCwqdN6g63sQ-1687829403-0-AU/LMZIqFgIuKcAzYtN3TXYbEke5hB0pu96ReAdhZHw6uxSnIIEyWJDI5XHyAQm0HGrhweuuwwwQ0kKNFr5JivQ='
    }

    response = requests.request("GET", url, headers=headers, data=payload)

    print(response.text)

    

    
 


    


if __name__ == '__main__':
    indeed_request()
