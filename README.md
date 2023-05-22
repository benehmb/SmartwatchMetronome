# SmartwatchMetronome

Metronome that vibrates for your Smartwatch.

This is a simple app, that uses the Vibrator of your Device and acts as a Metronome. You can change the duration and the Frequency

## Usage

Just open the App and press Start :)

## Settings

The first element ist the back-button. Press it and get back to the main screen.

The second element ist the frequency in BPM (Beats Per Minute). How often per minute should your device vibrate.

The last element is the duration. How long should it vibrate in MS (Milli Seconds). This is not a timer when it stops. Its just the duration for every beat.

## Screenshots

![Screenshot of Main](./Pictures/Main.png)
![Screenshot of Settings](./Pictures/Settings.png)

## ToDos for Developer

- [x] Code cleanup
- [ ] Maybe add sound
- [x] More documentation
- [x] Screenshots for `README.md`
- [x] New App-Icon

## Known problems and limitations
Keeps the screen on while running. Partial wake lock won't use on the vibrator and AmbientMode is not supported on API-Level 23 and normal android apps.