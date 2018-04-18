# Asthma Control - User Guide
>CDC, 
>Georgia Tech, 
>Team Epidemics
**Still need to add screenshots**

# Overview

Asthma guidelines suggest having a patient's asthma control evaluated regularly. This application is a working prototype used to ask patients a series of questions appropriate to their age group, evaluate their current control of their asthma across the domains of risk and impairment, and provide recommended action steps for treatment based on EPR-3 asthma guidelines. This information is then stored to a FHIR server.  

# Application Steps

This application is a web application, which currently runs locally with the default configuration (*see installation manual*). After configuring the environment and launching the application following the installation manual, a user navigates to http://localhost:8081 to begin using the application. The end user selects a patient and begins their questionnaire.

## Select a patient and home screen
The end user (a clinician, with a patient) will be presented with a list of patients from which they can select one to fill out a questionnaire for. Selecting the *"play"* icon for the row of the desired patient will launch the questionnaire. 
>The questionnaire launched depends on the age of the selected patient as of the day that the questionnaire is being taken. Patients are grouped to either 0-4, 5-11, or 12+ years of age in accordance with the EPR-3 guidelines. Each age group receives different questions in their questionnaire.


## Answer questions about asthma control
The end user will be presented with questions about the patient's control of asthma one question at a time. Each question must be answered to proceed. The user selects a question by clicking anywhere in the button associated with that answer, and upon clicking the button for the selected answer will change color. 
>To change an answer, the end user clicks on a button for another answer to select that answer. Once an answer has been selected, the "Next" button will become enabled, allowing the user to proceed to the next question in the questionnaire. 

At  any time during the question-answering portion, if the user wants to return to a previously answered question and adjust their answer they can press the "Previous" button. The answer they previously selected will remain highlighted, and they can change answers, as before, by selecting the button of another answer.

On the final question the "Next" button is replaced with a  "Submit" button, to end the portion of the questionnaire consisting of questions for the end user. When this button is pressed, the application will calculate the levels of asthma control in accordance with the EPR-3 guidelines and return this information to the patient.

## Calculation of asthma control,  actions for treatment, and submission to FHIR
The application uses the patient's age and the responses to each of the questions to calculate asthma control in the **Risk** and **Impairment** domains according to the EPR-3 guidelines. Each domain's control level is calculated independently.

After the user submits the questions and these control levels are calculated they are displayed to the end user along with **Recommended Actions for Treatment**, also provided by EPR-3 guidelines. Each domain receives recommended actions for treatment

These **Actions** are presented as editable to the end user. This allows for the clinician to customize the action steps for an individual patient (e.g., add patient-specific context for clarity or add or remove action steps) if desirable. 

When the end user is ready to save the asthma control levels they press the *Transmit to FHIR* button to save these levels to the FHIR server.
>**still under consideration**
The end user can select to save any combination of the questionnaire (if it doesn't exist) and responses to the questionnaire, patient information, and asthma control levels and actions for treatment via check boxes presented on the final page before transmitting data to FHIR

## Post-Submission

**still under consideration**
A configurable option is to show new tabs upon completion of uploading data to FHIR. This mode would not be enabled for end users, but for developers and testing this shows that data has been successfully saved to FHIR. Once data has been stored, for each FHIR resource selected for storage by the end user, a browser tab is opened containing the information returne when querying FHIR for the information stored whent he button is pressed. 


# Navigation Bar 

In addition to the information held on each page specific to that page, each page contains a common navigation bar across the top of the page with clickable links. This navigation bar is the same across all pages of the application.

- Patient
	- This link redirects to the home page, where a user can select a patient
-	Help
	-	This page links to a small page offering guidance, a subset of this user guide. 	
- Logout
	- This page will redirect to the home page, where a user can select a patient
