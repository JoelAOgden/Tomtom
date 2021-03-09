
###Run with:
`./gradlew run --console=plain`

-------
This became a much larger project then I suspected.

In order to get it functional in time I have had to cute a few corners. TDD went out the window at the 4th hour.

I choose not to test the view or the user input. This has resulted in a seemingly 
lack of testing, everything important has tests but things like system input and output
is difficult to test and I felt it was more important to get things running and usable.

Sadly I didn't have enough time at the point of writing this to implement a few things,
I will try to complete these before thursday either way.

    // TODO: set up java jar build properly (including gradle)
    // TODO: handle invalid input (instead of ignoreing)
    // TODO: create map pixelisation
    // TODO: draw map
    // TODO: create view console tests
    // TODO: clean the code a little bit
    // TODO: Do the TODOs

### The dungeon Map

Sadly, this was by far the biggest hurdle for me. I understand EXACTLY how to implement this
theoretically, but putting it into code that is testable and easy to read was another story.

In essence the plan was to step through the graph creating "pixels", these pixels would be printed
to an array as stepped through. The pixels could then be used to draw the map.

Simple... except making it was another story, and it very quickly became spaghetti. I didn't
finish it in time so removed the non-working code.
