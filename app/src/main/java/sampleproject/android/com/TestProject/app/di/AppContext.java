package sampleproject.android.com.TestProject.app.di;

import javax.inject.Qualifier;

@Qualifier //can also use Named annotation to differentiate between context if don't wanna use Qualifiers
public @interface AppContext {
}
