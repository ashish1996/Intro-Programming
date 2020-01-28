package a7;

public interface ObservablePicture extends Picture {
	void registerROIObserver(ROIObserver observer, Region r);
	void registerROIObserver(ROIObserver observer);
	
	void unregisterROIObserver(ROIObserver observer);

	void suspendObservable();
	void resumeObservable();
	
	void unregisterROIObservers(Region r);
	void findROIObservers(Region r);
}
