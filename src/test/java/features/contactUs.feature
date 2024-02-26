@Regression @ContactUs
Feature: User should be able to submit contact us request

  Background:
    Given User is on the contact us page of the application and scrolled down

    Scenario Outline: Verify user should be displayed the field specific icons
      Then User should be displayed <iconCaption> next to relevant text box

      Examples:
        | iconCaption |
        | "idCard" |
        | "emailEnvelope" |
        | "phone" |
        | "subjectEnvelope" |

    Scenario: Verify user should be displayed the message filed caption
      Then User should be displayed message caption next to message text area
#

    Scenario Outline: Verify user should be displayed the field labels
      Then User should be displayed <fieldLabel> label in the text box

      Examples:
        | fieldLabel |
        | "Name" |
        | "Email" |
        | "Phone" |
        | "Subject" |

    Scenario: Verify that user should be able to submit contact us form with valid successfully
      When User enter valid contact us details
      And Click on submit button
      Then User should be displayed contact us successful submission message
      And User should be displayed the name in the successful submission message
      And User should be displayed the subject in the successful submission message

    Scenario Outline: Verify user should see error message with invalid information
      When User enters <name> and <email> and <phone> and <subject> and <message>
      And Click on submit button
      Then User should be displayed error message
      And User should be displayed blank name text error
      And User should be displayed blank email text error
      And User should be displayed blank phone text error
      And User should be displayed error with acceptable range of "Phone"
      And User should be displayed blank subject text error
      And User should be displayed error with acceptable range of "Subject"
      And User should be displayed blank message text error
      And User should be displayed error with acceptable range of "Message"


      Examples:
        | name        | email           | phone        | subject           | message           |
        | "" | "" | "" | "" | "" |


    Scenario Outline: Verify user should not be able to submit invalid Name : <invalidName>
      When User enters <invalidName> in the name field
      And Click on submit button
      Then User should be displayed invalid "Name" format error message

      Examples:
        | invalidName |
        | "@£$%^&*($%^&" |
        | "123456789" |
        | "!3654£!_$£%!" |

    Scenario Outline: Verify user should not be able to submit invalid Email : <invalidEmail>
      When User enters <invalidEmail> in the email field
      And Click on submit button
      Then User should be displayed invalid "Email" format error message

      Examples:
        | invalidEmail|
        | "@missingUserName.com" |
        | "missingAtDotCom" |
        | "missingDomain@" |
        | "missingDotComFromDomain@c" |
        | "missingCom@xyz." |
        | "invalidEmailMissingAt.com" |
        | "spaces not@allowed.com" |
        | "double..dots@domain.com" |

    Scenario Outline: Verify user should not be able to submit invalid Phone Number : <invalidPhone>
      When User enters <invalidPhone> in the phone field
      And Click on submit button
      Then User should be displayed invalid "Phone" format error message

      Examples:
        | invalidPhone |
        | "stringAsPhoneNumber" |
        | "stringWith42353254" |
        | "!@£$%^&*%^&*" |
        | "+76726374627642" |
        | "+76 726374627642" |
        | "564 792 007" |
        | "777-111-222" |
#
    Scenario Outline: Verify user should not be able to submit out of range Phone Number : <outOfRangePhoneNumber>
      When User enters <outOfRangePhoneNumber> in the phone field
      And Click on submit button
      Then User should be displayed error with acceptable range of "Phone"

      Examples:
        | outOfRangePhoneNumber |
        | "777" |
        | "777711112222333344445555" |

    Scenario Outline: Verify user should not be able to submit out of range Subject : <outOfRangeSubjectText>
      When User enters <outOfRangeSubjectText> in the subject field
      And Click on submit button
      Then User should be displayed error with acceptable range of "Subject"

      Examples:
        | outOfRangeSubjectText |

        | "qwe" |
        | "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm" |

    Scenario Outline: Verify user should not be able to submit out of range message : <outOfRangeMessageText>
      When User enters <outOfRangeMessageText> in the message field
      And Click on submit button
      Then User should be displayed error with acceptable range of "Message"

      Examples:
        | outOfRangeMessageText |

        | "lessThanTwenty" |
        | "MessageTextWithMoreThan2000CharactersopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmQRSTUVWXYZ" |

