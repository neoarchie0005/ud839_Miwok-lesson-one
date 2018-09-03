package com.example.android.miwok;

public class Word {

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;

    /**
     * ImageResourceId for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * AudioResourceId for the word
     */
    private int mAudioResourceId;

    /**
     * First public constructor for Word.java.
     * This has the default translation
     * This has the miwok translation.
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Second public constructor for Word.java.
     * This has the default translation
     * This has the miwok translation.
     * This in addition has the Image Resource Id for the image associated with various words.
     * Also has the audio resource file to be associated with various list item.
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId,
                int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the default translation of the word translation
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get default translation of the miwok translation
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get ImageResourceId
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get AudioResourceId
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}