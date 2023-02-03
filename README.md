**Catalog of profiles**

Application created with
**AngularJS + Java Spring + MongoDB + Docker**

implemented:

    • the ability to create, edit and delete profiles
    • On the page there is a button “Add questionnaire” and a list
    of already collected questionnaires is displayed.
    • The list of questionnaires displays the full name from the questionnaire, 
    the “edit” button and the “delete” button.
    • When you click on the “Add Questionnaire” button,a form opens with the following fields:
        ◦ Last name
        ◦ Name
        ◦ Middle name
        ◦ Year of birth
        ◦ Gender
        ◦ Profession - drop-down list
        ◦ The values in the drop-down list change depending on the selected gender.
    • Save button

After saving, the data is written to the database and the 
questionnaire is displayed in the list.
When you click on the “edit” button, the same form opens,
but with pre-filled fields and the ability to edit them.

When you click the “delete” button, the profile is removed
from the database and disappears from the list.

I used the **mongock** library to initialize the data.

The application is built using **Docker**
To run, you need to install d**ocker and docker-compose.**
Then in the root directory of the project run the command in the terminal

    docker-compose-up

By the address

    http://localhost:8080/

a working application will be available.

![](https://github.com/Ruslan5/formCatalog/blob/main/img/fcl.gif)
