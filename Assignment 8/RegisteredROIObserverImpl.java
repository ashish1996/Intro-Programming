package a8;

// Implements the ROI Observer so that it can be retrieved and changed

public class RegisteredROIObserverImpl implements RegisteredROIObserver {

	Region roi;
	ROIObserver observer;
	
	public RegisteredROIObserverImpl(ROIObserver o, Region r) {
		observer = o;
		roi = r;
	}

	@Override
	public void notify(ObservablePicture picture, Region changed_region) {
		observer.notify(picture, changed_region);
	}

	@Override
	public Region getROI() {
		return roi;
	}

	@Override
	public ROIObserver unwrap() {
		return observer;
	}
}
