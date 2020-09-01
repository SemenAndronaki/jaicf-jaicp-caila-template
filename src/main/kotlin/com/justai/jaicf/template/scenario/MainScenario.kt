package com.justai.jaicf.template.scenario

import com.justai.jaicf.model.scenario.Scenario

object MainScenario : Scenario() {

    init {
        state("Start") {
            globalActivators {
                regex("/start")
            }
            action {
                reactions.say("So let's begin!")
            }
        }

        state("Hello") {
            activators {
                intent("Hello")
            }

            action {
                reactions.say("Hi there!")
            }
        }

        state("Bye") {
            activators {
                intent("Bye")
            }

            action {
                reactions.say("See you soon!")
            }
        }
        
        state("Delivery") {
            activators {
                intent("Delivery")
            }

            action {
                reactions.say(activator.caila?.topIntent?.answer.toString())
            }
        }

        fallback {
            reactions.say("I have nothing to say yet...")
        }
    }
}
