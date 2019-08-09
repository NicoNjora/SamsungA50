package com.nicolletnjora.samsunga50.Activities;

import android.util.Log;
import android.util.SparseArray;
import android.widget.TextView;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;

public class OcrDetectorProcessor implements Detector.Processor<TextBlock> {
    private TextView textView;
    private String capturedText;
    private GraphicOverlay<OcrGraphic> graphicOverlay;

    public OcrDetectorProcessor(GraphicOverlay<OcrGraphic> ocrGraphicOverlay, TextView text) {
        graphicOverlay = ocrGraphicOverlay;
        textView = text;
    }

    @Override
    public void release() {
        graphicOverlay.clear();
    }

    @Override
    public void receiveDetections(Detector.Detections<TextBlock> detections) {
        graphicOverlay.clear();
        final SparseArray<TextBlock> items = detections.getDetectedItems();
        if (items.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < items.size(); i++) {
                TextBlock item = items.valueAt(i);
                stringBuilder.append(item.getValue());
                stringBuilder.append("\n");
                if(item != null && item.getValue() != null) {
                    Log.d("Processor", "Text Detected!" + item.getValue());
                    OcrGraphic graphic = new OcrGraphic(graphicOverlay, item);
                    graphicOverlay.add(graphic);
                }
            }
//                    textView.setText(stringBuilder.toString());
            capturedText = stringBuilder.toString();
//            textView.post(new Runnable() {
//                @Override
//                public void run() {
//                    StringBuilder stringBuilder = new StringBuilder();
//                    for (int i = 0; i < items.size(); i++) {
//                        TextBlock item = items.valueAt(i);
//                        stringBuilder.append(item.getValue());
//                        stringBuilder.append("\n");
//                        if(item != null && item.getValue() != null) {
//                            Log.d("Processor", "Text Detected!" + item.getValue());
//                            OcrGraphic graphic = new OcrGraphic(graphicOverlay, item);
//                            graphicOverlay.add(graphic);
//                        }
//                    }
////                    textView.setText(stringBuilder.toString());
//                    capturedText = stringBuilder.toString();
//                }
//            });
        }
    }

    public String get_captured_text() {
        return capturedText;
    }
}
