from flask import Flask, render_template
import json

app = Flask(__name__)


@app.route('/')
def jobs():
    """
    Loads Software Engineer roles in Charlotte from the jobs.json file into home page when route is hit.
    """
    with open('jobs.json', 'r') as f:
        # TODO 12: Get the jobs from the JSON file
        # - use only the Charlotte Software Engineer jobs
        # - use the `load` method and then narrow the result down to the correct data
        pass # Replace pass with the correct code
        data = json.load(f)
        
        # search for Charlotte Software Engineer jobs only
        jobs = [job for job in data if job['location'] == 'Charlotte' and job['role'] == 'Software Engineer']
        
    return render_template('index.html', jobs=jobs)



if __name__ == '__main__':
    app.run(debug=True)
