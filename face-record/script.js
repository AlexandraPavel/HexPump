let videoElement = document.getElementById('videoElement');
let startButton = document.getElementById('startButton');
let stopButton = document.getElementById('stopButton');
let mediaRecorder;
let recordedChunks = [];

// Check if the browser supports the necessary APIs
if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
  startButton.addEventListener('click', async () => {
    startButton.disabled = true;
    stopButton.disabled = false;

    try {
      navigator.mediaDevices.getUserMedia({ video: true }).then(stream => {

      

      // Display the video stream in the video element
      videoElement.srcObject = stream;
      videoElement.play();

      // Create a MediaRecorder instance to record the stream
      mediaRecorder = new MediaRecorder(stream);

      // Event handler for when data is available to be recorded
      mediaRecorder.ondataavailable = (event) => {
        console.log("gata frate")
        if (event.data.size > 0) {
          recordedChunks.push(event.data);
        }
      };

      // Event handler for when recording is stopped
      mediaRecorder.onstop = () => {
        const recordedBlob = new Blob(recordedChunks, { type: 'video/webm' });
        // You can do something with the recorded video blob, like save it or upload it
        // For example, create a download link to save the video
        const downloadLink = document.createElement('a');
        downloadLink.href = URL.createObjectURL(recordedBlob);
        downloadLink.download = 'recorded-video.webm';
        downloadLink.click();

        recordedChunks = [];
      };

      // Start recording
      mediaRecorder.start();});
    } catch (error) {
      console.error('Error accessing the camera:', error);
    }
  });

  stopButton.addEventListener('click', () => {
    startButton.disabled = false;
    stopButton.disabled = true;

    // Stop recording
    mediaRecorder.stop();

    // Stop the video stream and remove it from the video element
    let stream = videoElement.srcObject;
    let tracks = stream.getTracks();
    tracks.forEach((track) => {
      track.stop();
    });
    videoElement.srcObject = null;
  });
} else {
  console.error('getUserMedia is not supported on your browser');
}
